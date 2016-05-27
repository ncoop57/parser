package org.codeontology.build.gradle;

import org.codeontology.CodeOntology;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AndroidLoader extends GradleLoader {

    public AndroidLoader(AndroidProject project) {
        super(project);
    }

    @Override
    public void loadDependencies() {
        System.out.println("Loading dependencies for Android project...");
        addClasspathTask();
        build();
        runTask("CodeOntologyCpFile");
        CodeOntology.signalDependenciesDownloaded();
        loadClasspath();
        loadAndroidSdkDependencies();
    }

    private void build() {
        try {
            getProcessBuilder("build").start().waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void addClasspathTask() {
        String name = "CodeOntologyCpFile";
        String variants = null;
        if (hasPlugin("com.android.application")) {
            variants = "applicationVariants";
        } else if (hasPlugin("com.android.library")) {
            variants = "libraryVariants";
        }
        if (variants != null) {
            String body =  "{\n" +
                    "\tbuildDir.mkdirs()\n" +
                    "\tandroid." + variants + ".all { variant -> \n" +
                    "\t\tnew File(buildDir, \"cp" + CodeOntology.SUFFIX + "\").text = variant.javaCompile.classpath.asPath\t\n" +
                    "\t}\n" +
                    "}";
            addTask(name, body);
        }
    }

    private void loadAndroidSdkDependencies() {
        String androidHome = System.getenv().get("ANDROID_HOME");
        if (androidHome == null) {
            CodeOntology.showWarning("ANDROID_HOME environment variable is not set.");
        }
        File appBuild = new File(getProject().getPath() + "/build.gradle");

        String build = "";

        try (Scanner scanner = new Scanner(appBuild)) {
            scanner.useDelimiter("\\Z");
            if (scanner.hasNext()) {
                build = scanner.next();
            }
        } catch (FileNotFoundException e) {
            CodeOntology.showWarning("Could not find file build.gradle for module app.");
        }

        String sdkVersion = null;

        String androidBlock = ".*android\\s*\\{.*";
        Pattern pattern = Pattern.compile(androidBlock + "compileSdkVersion\\s+([0-9]+).*", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(build);
        if (matcher.matches()) {
            sdkVersion = matcher.group(1);
        } else {
            pattern = Pattern.compile(androidBlock + "targetSdkVersion\\s+([0-9]+).*", Pattern.DOTALL);
            matcher = pattern.matcher(build);
            if (matcher.matches()) {
                sdkVersion = matcher.group(1);
            }
        }
        if (sdkVersion != null) {
            getLoader().lock();
            getLoader().loadAllJars(androidHome + "/platforms/android-" + sdkVersion);
            getLoader().release();
        } else {
            CodeOntology.showWarning("Could not find sdk version.");
        }
    }
}

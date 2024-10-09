A thin JNI wrapper over [the portable file dialogs library](https://github.com/samhocevar/portable-file-dialogs) for selecting only files and folders. 

This is for windows and linux x64 only as I dont use Mac. It does not depend on swing or awt.

To use include in your pom.xml:
```xml
 <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>

<dependencies>
        <dependency>
            <groupId>com.github.newk5</groupId>
            <artifactId>java-portable-dialogs</artifactId>
            <version>1.0</version>
        </dependency>
</dependencies>
```

Examples:

```java
  File folder = Dialog.selectFolder("Select folder", "C:\\");
  File file = Dialog.selectFile("Select file", "C:\\");
  List<File> files = Dialog.selectFile("Select files", "C:\\");
  List<File> pdfs =  Dialog.selectFiles("Select files", "C:\\", "PDF files", "*.pdf");
```

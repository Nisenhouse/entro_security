package org.example;

import java.util.List;

public class Commit {
    List<File> files;

    public Commit(List<File> files) {
        this.files = files;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public class File {
        private String filename;
        private String patch;

        public File(String filename, String patch) {
            this.filename = filename;
            this.patch = patch;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getPatch() {
            return patch;
        }

        public void setPatch(String patch) {
            this.patch = patch;
        }
    }
}

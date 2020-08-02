package models;

public class Project {
    private String name;
    private String announcement;
    private boolean show_announcement;
    private int suite_mode;
    private boolean is_completed;
    private String job;
    private String password;
    private String email;

    public static class Builder {
        private Project newProject;

        public Builder() {
            newProject = new Project();
        }

        public Builder withName(String name) {
            newProject.name = name;
            return this;
        }

        public Builder withJob(String job) {
            newProject.job = job;
            return this;
        }

        public Builder withEmail(String email) {
            newProject.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            newProject.password = password;
            return this;
        }

        public Builder withAnnouncement(String announcement) {
            newProject.announcement = announcement;
            return this;
        }

        public Builder withIsShowAnnouncement(boolean isShowAnnouncement) {
            newProject.show_announcement = isShowAnnouncement;
            return this;
        }

        public Builder withIsCompleted(boolean is_completed) {
            newProject.is_completed = is_completed;
            return this;
        }

        public Builder withType(int suite_mode) {
            newProject.suite_mode = suite_mode;
            return this;
        }

        public Project build() {
            return newProject;
        }
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getJob() {
        return job;
    }

    public String getEmail() { return email;}

    public String getAnnouncement() {
        return announcement;
    }

    public int getSuiteMode() {
        return suite_mode;
    }

    public boolean isShow_announcement() {
        return show_announcement;
    }

    public boolean isIs_completed() {
        return is_completed;
    }

    public int getSuite_mode() {
        return suite_mode;
    }
}

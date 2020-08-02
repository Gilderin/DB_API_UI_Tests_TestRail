package models;

public class Projects {
    private String nameProject;
    private String typeProject;

    public Projects(String nameProject, String typeProject) {
        this.nameProject = nameProject;
        this.typeProject = typeProject;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public String getTypeProject() {
        return typeProject;
    }

    public void setTypeProject(String typeProject) {
        this.typeProject = typeProject;
    }
}

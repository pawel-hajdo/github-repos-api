package springboot.githubapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Repo {

    private String name;
    private Owner owner;
    private Boolean fork;
    private List<Branch> branches;

    public Repo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public Boolean getFork() {
        return fork;
    }

    public void setFork(Boolean fork) {
        this.fork = fork;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
}

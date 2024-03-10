package com.hexacta.models.web;

public class CreateUserRequestBuilder {
    private CreateUserRequest userRequest;

    private CreateUserRequestBuilder(){
        userRequest = new CreateUserRequest();
    }

    public static CreateUserRequestBuilder aUser(){
        return new CreateUserRequestBuilder();
    }

    public CreateUserRequestBuilder withName(String name){
        this.userRequest.setName(name);
        return this;
    }

    public CreateUserRequestBuilder withLastName(String lastName){
        this.userRequest.setLastName(lastName);
        return this;
    }

    public CreateUserRequestBuilder withEmail(String email){
        this.userRequest.setEmail(email);
        return this;
    }

    public CreateUserRequestBuilder withCompany(String company){
        this.userRequest.setCompany(company);
        return this;
    }

    public CreateUserRequestBuilder withMessage(String yourMessage){
        this.userRequest.setYourMessage(yourMessage);
        return this;
    }

    public CreateUserRequestBuilder withJob(String job){
        this.userRequest.setJob(job);
        return this;
    }

    public CreateUserRequest build(){
        return userRequest;
    }
}

package org.example.immutable_builder;

import lombok.ToString;

import javax.validation.constraints.Size;


@ToString
public final class User {

    public final String firstName;
    public final String lastName;
    public final String eMail;



    User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.eMail = builder.eMail;
    }

    public static  class UserBuilder {

        @Size(min = 4, max = 20, message
                = "Name must be between 4 and 20 characters")
        private String firstName ="";
        private String lastName ="";
        private String eMail ="";

        public static UserBuilder newInstance()
        {
            return new UserBuilder();
        }

        public UserBuilder() {
        }


        public UserBuilder firstName(String firstname) {
            this.firstName = firstname;
            return this;
        }

        public UserBuilder lastName(String lastname) {
            this.lastName = lastname;
            return this;
        }

        public UserBuilder email(String email) {
            this.eMail = email;
            return this;
        }

        public User build() {
            return new User(this);
        }




    }



}
package myapp

import rest.docs.UserService

class BootStrap {

    UserService userService

    def init = { servletContext ->
        userService.initUsers()
    }

    def destroy = {
    }
}

# Docker for Dev

The goal of this setup is to minimize or eliminate local setup to get started.  Simply installing Docker and running 
these commands should be sufficient to be productive.  

This also has the benefit of keeping all artifacts local to the project directory (other than Docker itself).  So, when 
you are finished, simply delete this directory.  If you also want to delete Docker and its artifacts, see 
[Docker Cleanup](#docker-cleanup) below.

## Install Docker

See: [https://www.docker.com/community-edition#/download]()

#### Homebrew on Mac

If you prefer to use homebrew for managing your software installation and don't want to download directly, this will 
get you going with docker:

```bash
$ brew tap caskroom/cask
$ brew cask install docker
```

Now start `Docker.app` which will launch a menu-bar application.

## Dev environment

For doing builds you will use SBT wrapped in a docker container.  There is a helper script in the root of the repo 
called `./sbtd`.  Take a look at the script source to understand what it is doing from a docker perspective.  The 
default behavior should be sufficient for completing the interview tasks.

#### Basic Build

```bash
$ ./sbtd build
```

#### Run Tests

```bash
$ ./sbtd test
```

#### Clean

```bash
$ ./sbtd clean
```

#### Interactive SBT Console

```bash
$ ./sbtd
```

<a name="docker-cleanup"></a>
## Docker Cleanup

#### Remove container and image

```bash
$ docker rm -f sbtd
$ docker rmi 1science/sbt:0.13-oracle-jdk-8
```

#### Remove Docker
1. Stop the Docker application
2. Move the Docker application to the trash
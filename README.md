# Spring Framework in Depth

> Companion repository for the LinkedIn Learning course *Spring Framework in Depth*. Each branch represents the state of the sample code used in a particular video.

## Table of Contents

- [Overview](#overview)
- [Learning objectives](#learning-objectives)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installing](#installing)
  - [Branch layout](#branch-layout)
- [Development](#development)
- [Contributing](#contributing)
- [Authors](#authors)
- [License](#license)

## Overview

Spring is an application framework and inversion-of-control (IoC) container for the Java platform. This repository hosts the sample code that accompanies the LinkedIn Learning course of the same name. It is intended for learners who want to follow along with the videos, experiment with concepts, or use the code as a reference for their own projects.

## Learning objectives

- Configure the Spring ApplicationContext to access components, load files, publish events, and manage the inversion‑of‑control container for Java applications.
- Implement beans within the IoC container using a modern Java configuration workflow.
- Analyze the Spring lifecycle to extend the framework and troubleshoot issues.
- Utilize aspect-oriented programming to integrate reusable behaviors into Java applications.


## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or later
- Apache Maven 3.6 or later
- Git 2.x

### Installing

```bash
git clone https://github.com/gutors/spring-in-depth.git
cd spring-in-depth
```

Switch to a branch corresponding to a video:

```bash
git checkout 02_03  # chapter 2, video 3
```

### Branch layout

The repository uses one branch per lesson. Branch names follow the pattern `CHAPTER#_MOVIE#`. Suffix `b`/`e` denotes the beginning and end states of an exercise. The `main` branch holds the final code.

### Common issues

If Git complains about local changes when switching branches:

```
error: Your local changes to the following files would be overwritten by checkout:        [files]
```

Either commit or stash your changes:

```bash
git add .
git commit -m "work in progress"
# or
 git stash
```

## Authors

* **Gustavo Schmid de Jesus** – <https://github.com/gutors>

## License

This repository does not include an explicit license. Add a `LICENSE` file if you intend to distribute or reuse the code publicly.



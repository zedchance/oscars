# team-3 oscars

A REST API for searching for Oscar winning/nominated movies. Created by `team3` for CSC131 in Fall 2020.

## Team

Name | Role
--- | ---
Zed Chance | Scrum master / Dev
Victor Galbraith | Product Owner / Dev
Nicholas Bailey | Dev
Harnoor Singh | Dev
Visoth Cheam | Dev
Michael Lutsik | Dev

## Deliverables

Can be viewed [here](DELIVERABLES.md).

## Use

Run the `ApiApplication` file and visit `localhost:8080`.

### Endpoints

#### `/hello`

This is a test endpoint to make sure that project is working correctly.
It optionally takes a parameter `name`.

For example:

```
localhost:8080/hello?name=World
```

#### `/all`

This is an endpoint that returns all movies available.

For example:

```
localhost:8080/all
```

#### `/movie`

This is an endpoint that returns a specific movie by title.
It uses the syntax `/movie/title`

For example:

```
localhost:8080/movie/titanic
```

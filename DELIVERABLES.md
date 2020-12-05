# `team-3` Deliverables

## Minimum

### Product

- [x] Must provide a REST endpoint that delivers a collection resource in JSON. 
    - The `/all` endpoint returns a collection resource in JSON.
- [x] Must provide a REST endpoint that delivers a singleton resource in JSON.
    - The `/movie/{title}` endpoint returns a singleton resource in JSON.
- [x] Must provide a REST endpoint that allows search of 1 Oscar category and returns results containing the nominees in JSON.
    - The `/category/{name}` endpoint returns a collection resource of a specific Oscar category in JSON.
- [x] Must provide a minimum level of documentation regarding access, input, and output to your API endpoints. 
    - API endpoint access documented in [the wiki](https://github.com/zedchance/oscars/wiki/Endpoints).

### Process

- [x] Must have a product vision.
- [x] Must have one persona.
- [x] Must store source code in a repository such as GitHub
    - [x] Instructor must receive invite to/location of repository.
    - [x] There must be evidence of ongoing repository activity for each sprint.
- [x] Must use Flying Donut to track and adhere to Scrum Process
    - [x] Instructor must receive invite to/location of project.
- [x] Must implement AT LEAST one user story per sprint.
- [x] Must incorporate unit testing for a minimum of 2 classes.
    - [Unit tests](https://github.com/zedchance/oscars/tree/master/src/test/java/api) implemented for both the Movie class, and the Award class.

### Presentation

- [ ] Presentation details 
    - [ ] Slides
    - [ ] Discuss project and/or process
    - [ ] Demo a working project

## Non-Minimum

### Product

- [x] The results returned contain data which correlates the Oscar category results with additional data from an outside source such as OMDb, TMDb, TVDb etc. by providing a link to an external site for the movie.
    - OMDb is used when the singleton endpoint `/movie/{title}` is called. This provides a link to the IMDb page.
- [x] The search feature allows limiting results to a date range.
    - `/all` takes optional parameters to specify a year range. For example: `/all/1950` or `/all/1950/1955`.
- [x] More than one category can be searched.
    - The `/category/{name}` category can search any of the Oscar categories listed [here](https://github.com/zedchance/oscars/wiki/Endpoints#category).
- [x] More than one endpoint that delivers a collection resource.
    - `/all`, `/category/{name}`, and `/winner` return collection resources.
- [x] More than one endpoint that delivers a singleton resource.
    - `/movie` and `/random` return singleton resources, a movie by title or a randomly selected movie, respectively.
- [x] GUI for the product (or portions thereof).
    - The GUI can be accessed at the root, `localhost:8080/`
- [x] Well-designed HTML page documenting API endpoints and example inputs/outputs.
    - A page documenting API endpoints, including example input and output, can be found [here](https://github.com/zedchance/oscars/wiki/Endpoints) in the wiki.

### Process

- [ ] Incorporate test-driven development practice for one Sprint.
- [x] Refactor code in a significant manner with a clear and stated goal for refactoring.
    - The repeated code in `FetchFromCSV` was refactored in a manner that was tracked via Flying Donut #159. This was merged in [#26](https://github.com/zedchance/oscars/pull/26).
- [ ] Incorporate Contextual Inquiry/Elicitation techniques to create visual persona(s) and develop additional personas.
- [x] Create mockups for proposed GUI (even if not implemented).
    - Mockups can be viewed [here](https://github.com/zedchance/oscars/wiki/Mockups).
- [x] Incorporate pair programing during one Sprint.
    - Pair programming was performed during the development of PR [#30](https://github.com/zedchance/oscars/pull/30), video can be viewed [here](https://www.youtube.com/watch?v=Cvt6B0-nuSE).
- [ ] Incorporate one or more design patterns.
- [x] Adopt a coding standard and follow it.
    - The team adopted a coding standard, and enforced it via [these files](.idea/codeStyles).
- [ ] Use a database to store and retrieve Oscar data using queries.
- [x] Analyze code using SonarQube or similar tool.
    - We analyzed our code using SonarQube, and documented it [here](https://github.com/zedchance/oscars/wiki/SonarQube-analysis).
- [x] Explain and document obstacles encountered during the project and how those obstacles were handled.
    - All obstacles encountered by the team were documented/discussed using GitHub's issue/pull request system, the entire stream can be viewed [here](https://github.com/zedchance/oscars/issues?q=).

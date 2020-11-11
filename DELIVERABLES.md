# `team-3` Deliverables

## Minimum

### Product

- [x] Must provide a REST endpoint that delivers a collection resource in JSON. 
    - The `/all` endpoint returns a collection resource in JSON.
- [x] Must provide a REST endpoint that delivers a singleton resource in JSON.
    - The `/movie/{title}` endpoint returns a singleton resource in JSON.
- [ ] Must provide a REST endpoint that allows search of 1 Oscar category and returns results containing the nominees in JSON.
- [x] Must provide a minimum level of documentation regarding access, input, and output to your API endpoints. 
    - API endpoint access documented in [README](README.md#Use).

### Process

- [x] Must have a product vision.
- [x] Must have one persona.
- [x] Must store source code in a repository such as GitHub
    - [x] Instructor must receive invite to/location of repository.
    - [ ] There must be evidence of ongoing repository activity for each sprint.
- [x] Must use Flying Donut to track and adhere to Scrum Process
    - [x] Instructor must receive invite to/location of project.
- [x] Must implement AT LEAST one user story per sprint.
- [x] Must incorporate unit testing for a minimum of 2 classes.
    - Unit tests implemented for both the Movie class, and the Award class.

### Presentation

- [ ] Presentation details 
    - [ ] Slides
    - [ ] Discuss project and/or process
    - [ ] Demo a working project

## Non-Minimum

### Product

- [x] The results returned contain data which correlates the Oscar category results with additional data from an outside source such as OMDb, TMDb, TVDb etc. by providing a link to an external site for the movie.
    - OMDb is used when the singleton endpoint `/movie/{title}` is called. This provides a link to the IMDb page.
- [ ] The search feature allows limiting results to a date range.
- [ ] More than one category can be searched.
- [ ] More than one endpoint that delivers a collection resource.
- [ ] More than one endpoint that delivers a singleton resource.
- [ ] GUI for the product (or portions thereof).
- [ ] Well-designed HTML page documenting API endpoints and example inputs/outputs.

### Process

- [ ] Incorporate test-driven development practice for one Sprint.
    - As evidenced by timestamps on check in for test code vs. check in for implementation code.
- [ ] Refactor code in a significant manner with a clear and stated goal for refactoring.
    - As evidenced by an implemented story from the Product Backlog with corresponding work in the repository.
- [ ] Incorporate Contextual Inquiry/Elicitation techniques to create visual persona(s) and develop additional personas.
    - As evidenced by notes taken from the inquiries and creation of additional visual persona(s) beyond the minimum (part of deliverable 2).
- [x] Create mockups for proposed GUI (even if not implemented).
    - ADD GUI MOCKUP LINK HERE.
- [ ] Incorporate pair programing during one Sprint.
    - As evidenced by a 1-minute clip of a recording in-person or Use Together session with link included in final deliverable.
- [ ] Incorporate one or more design patterns.
    - Indicate in user story which design pattern for which class(es) and provide comments in code (checked in to repository).
- [x] Adopt a coding standard and follow it.
    - The team adopted a coding standard, and enforced it via [these files](.idea/codeStyles).
- [ ] Use a database to store and retrieve Oscar data using queries.
- [ ] Analyze code using SonarQube or similar tool.
    - As evidenced by screenshot of SonarQube analysis.
- [x] Explain and document obstacles encountered during the project and how those obstacles were handled.
    - All obstacles encountered by the team were documented/discussed using GitHub's issue/pull request system, the entire stream can be viewed [here](https://github.com/zedchance/oscars/issues?q=).

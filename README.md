# Digital Petersburg hackathon project

**Life Quality Index** (Want To Live Here service) is a winner project, created by Team Dune at a Digital Petersburg hackathon, held in April of 2024.

The goal of the hackathon was to come up with and develop a digital service that would be useful for the citizens of St. Petersburg using open data from city's public APIs.
This event was organized by [Electrotechnical University](https://etu.ru/en) in partnership with operators of public city APIs and IT companies.

There were two contests. The first one, spanning a week prior to the hackathon, was a contest for the best idea of a service. The second one was the hackathon itself, giving around 30 hours to code the idea. Both contests culminated in pitches by participating teams.

This project won in both nominations: </br>
[Best Service Idea]() </br>
[Best Service](/github/bestservice.jpg)

**Team Dune is:** </br>
[DenisionSoft](https://github.com/DenisionSoft) </br>
[M-Masha](https://github.com/M-Masha) </br>
[nastasia-av](https://github.com/nastasia-av) </br>
[WhoLeb](https://github.com/WhoLeb) </br>
[Qusild](https://github.com/Qusild) </br>

## Demo
Docker images of backend and frontend apps are published in this repository's packages. </br>
To try them out, you can follow these steps: </br>
1. Clone this repository
2. Run `docker compose up --build` in the `/github` folder to pull the images and serve the frontend
3. Visit `http://localhost:8081` to reach the frontend.

Alternatively, you can build the images yourself by using the compose file in the root of the repository. For this, run the command from step 2 in the root directory, rather that in `/github`.

Both compose files contain a burner API key for the backend to access APIs. This is enough for a demo, but if you want, you can replace it with your own key by changing the `SPB_TOKEN` environment variable in the compose file.

## Screenshots

![front](/github/front.png)

![form](/github/form.png)

![result](/github/result.png)

## Commit history
The last commit made during the event was [7c54dd1](https://github.com/DenisionSoft/life-quality-index/commit/7c54dd1e351132662bc1da9ce738ad8eb23a9152), which represents the state of the repository when the coding time was up. Any commit since then serves only to clean up the code a little, write this README file and make the project demoable by publishing the images.

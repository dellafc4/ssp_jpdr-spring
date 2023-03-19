# ssp_jpdr-spring

Gradle, Java18 Spring-boot application.
It exposes 2 endponts to serve a Rock, Paper Scissors Game.
  1. GET game/start -> Json response containing the title, instructions, game rules and available moves

  response:

    {
      "gameTitle": string,
      "instructions": string,
      "gameRules": string,
      "moveOptions": array
    }
  2. POST game/result -> Json request body shall contain one of the available moves selected by the player. Json response will contain the gameOutome (who won) and the enemy move.
  
  request:

    {
      "playerMove":string
    }
  response:

    {
      "gameOutcomeValue": string,
      "enemyMove": string 
    }
  
When running the respective ssp_jpdr angular application make sure it is running on http://localhost:8080  

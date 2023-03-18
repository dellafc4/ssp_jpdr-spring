# ssp_jpdr-spring

Java18 Spring-boot aplication.
It exposes 2 endponts to serve a Rock, Paper Scissors Game
  1. GET game/start -> Json response cointating the title, instructions, game rules and available moves
  2. POST game/result -> Json request body shall contain one of the available moves selected by the player. Json response will contain the gameOutome (who won) and the enemy move.
  
When runnig the respecive ssp_jpdr angular application make sure it is serving on http://localhost:8080  

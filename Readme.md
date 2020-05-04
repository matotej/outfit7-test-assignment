# Outfit 7 QA automation assignment
I used the provided base for my starting point. There are three test scenarios. I used first one to feed Tom.

## Test scenarios

The provided solution helped me to load the main screen.
In the first and the last scenario I take screenshots that are stored under the Screenshots/{timestamp}/ folder.

### Feed Tom
Scenario steps:
1. Click on **Food icon**.
2. Click on the **Milk icon**.
3. Take a screenshot after 2 seconds (TomDrinkingMilk.jpg).
4. Wait for animation to stop

### Verify How to play instruction
Scenario steps:
1. Click in **Info icon**
2. Click on **How to play**
3. Read and **assert** the text of the first bullet point
4. Click on **Close icon**

### Record and play video
Scenario steps:
1. Click on **Camera icon** to **start** recording
2. Click on **Gasmask icon**
3. Wait 2 seconds for animation to stop.
4. Click on **Paw icon**
5. Wait 4 seconds for animation to stop.
6. Click on **Camera icon** to **stop** recording
7. Click on **Play button** to **start** the video
8. Take a screenshot after 1.5 seconds of the **Gasmask action** (TomGasMask.jpg).
9. Take a screenshot after 3.5 seconds of the **Pawn action** (TomPawn.jpg).
10. Click on **Close icon**


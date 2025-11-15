# Java ECS Game Engine – README

## Overview
This project is a minimalist Entity-Component-System (ECS) game engine built in Java. It demonstrates how to use composition over inheritance to achieve modular, extensible, and observable game logic—ideal for small games, prototyping, or as an educational foundation for deeper engine work.

- **Entities**: Uniquely identified objects (IDs only), no data or logic by themselves
- **Components**: Pure data types (e.g., Position, Velocity, Health) you can mix and match per entity
- **Systems**: Logic units that operate over entities with specific components (e.g., MovementSystem, HealthSystem)

This engine is designed for clarity, clean code, and observability—every state change or update is easy to log, trace, and test.[2][3]

***

## Features
- Clean ECS architecture: Entities as IDs, pure-data Components, Systems handle all logic
- Extensible: Add new features by pairing new components and systems—no refactoring needed
- Observable: Logs all major events, state changes, system updates
- Testable and modular: Easy to add or isolate systems and run unit tests

***

## Project Structure
- `/src/ecs/` — Main package with entities, components, systems, and the engine
    - `Entity.java`
    - `Component.java` (interface)
    - `PositionComponent.java`, `VelocityComponent.java`, etc.
    - `MovementSystem.java`, `HealthSystem.java`, etc.
    - `ECSWorld.java` — holds all component maps
    - `GameEngine.java` — main loop

***

## Getting Started
### Prerequisites
- Java 8+
- Recommended: IntelliJ IDEA for best development experience

### Run the Engine
1. **Clone the repo** and open in IntelliJ IDEA.
2. **Compile and run** the `GameEngine` main class.
3. Watch logs as systems update entity positions, health, and other components in real time.

***

## Example Usage
```java
Entity player = world.createEntity();
world.positions.put(player.getId(), new PositionComponent(0, 0));
world.velocities.put(player.getId(), new VelocityComponent(1, 1));
world.healths.put(player.getId(), new HealthComponent(10));

MovementSystem moveSys = new MovementSystem();
moveSys.update(world); // Logs state change for player
```

***

## Adding New Features
To add a new feature (like a shield or inventory):
1. **Create a new component** (e.g., `ShieldComponent`)
2. **Create a new system** (e.g., `ShieldSystem`) that queries for all entities with the required components
3. Attach the new component to relevant entities and call the new system in the game loop—no changes to existing systems required.[3][2]

***

## Principles & Best Practices
- **Composition over inheritance**: Keep every behavior modular
- **Separation of state and logic**: Data in components, logic in systems
- **Clear observability**: Log each system activity and entity state change
- **Intention-revealing names** for components, systems, and functions

***

## References
- [Dominion ECS (Java)](https://github.com/dominion-dev/dominion-ecs-java)[1]
- [How to design an ECS in Java (Reddit)](https://www.reddit.com/r/roguelikedev/comments/a1ssfz/how_to_design_an_ecs_in_java/)[2]
- [JECS, Java Student Project ECS Engine](https://github.com/klavinski/jecs)[3]

[1](https://github.com/dominion-dev/dominion-ecs-java)
[2](https://www.reddit.com/r/roguelikedev/comments/a1ssfz/how_to_design_an_ecs_in_java/)
[3](https://github.com/klavinski/jecs)
[4](https://www.youtube.com/watch?v=HkG8ZdhoXhs)
[5](https://devlog.hexops.com/2022/lets-build-ecs-part-1/)
[6](https://news.ycombinator.com/item?id=21892126)
[7](https://hexdocs.pm/sesopenko_ecs/readme.html)
[8](https://github.com/SanderMertens/ecs-faq)
[9](https://www.youtube.com/watch?v=6djXCScdK54)
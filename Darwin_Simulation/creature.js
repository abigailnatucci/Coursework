/**
 * A Creature object is a single creature in this simulation.
 */
class Creature {

    /**
     * Constructs a Creature object.
     * 
     * @param {Species} species The species of this creature. 
     * @param {Point} point The position of this creature 
     * @param {Number} direction The direction that this Creature is facing.
     *      One of the properties of the Direction object in geometry.js.
     * @param {World} world A reference to the world object for this simulation. 
     */
    constructor( species, point, direction, world ) {
        this.location = point;
        this.direction = direction;
        this.species = species;
        this.world = world;

        // The program counter (pc) for this creature.  This keeps track of the
        // current instruction in the creature's program.
        this.pc = 1;
    }

    getSpecies() {
        return this.species;
    }

    getDirection() {
        return this.direction;
    }

    getLocation() {
        return this.location;
    }

    /**
     * Executes this creature's program from the current instruction until one turn
     * is complete.  A turn is complete when one of the instructions:  hop, left,
     * right, or infect is executed.  Prior to that, the creature may execute one or
     * several instructions.
     * 
     * You can access the instructions for the species of this creature via: 
     * this.species.programStep() (see species.js).
     */
    takeOneTurn() {
        let inTurn = true;
        while (inTurn) {
            let step = this.species.programStep(this.pc-1);
            let address = step.address;
            let dest = Geometry.adjacentPoint(this.location, this.direction);
            switch (step.opcode) {
                case "hop":
                    if ((this.world.getContents(dest.row, dest.col) === undefined) && this.world.inRange(dest)) {
                        this.location = dest;
                    }
                    inTurn = false;
                    this.pc++;
                    break;

                case "left":
                    let leftDirection = Geometry.leftFrom(this.direction);
                    this.direction = leftDirection;
                    inTurn = false;
                    this.pc++;
                    break;

                case "right":
                    let rightDirection = Geometry.rightFrom(this.direction);
                    this.direction = rightDirection;
                    inTurn = false;
                    this.pc++;
                    break;

                case "infect":
                    let creat = this.world.getContents(dest.row,dest.col);
                    if(creat !== undefined) {
                        creat.species = this.species;
                        creat.pc = 1;
                    }
                    inTurn = false;
                    this.pc++;
                    break;

                case "ifempty":
                    if (this.world.getContents(dest.row, dest.col) === undefined) {
                        this.pc++;
                    }
                    else {
                        this.pc = address;
                    }
                    inTurn = false;
                    break;

                case "ifwall":
                    if (!this.world.inRange(dest)) {
                        this.pc = address;
                    }
                    else {
                        this.pc++;
                    }
                    break;

                case "ifsame":
                    if (this.world.getContents(dest.row, dest.col) === undefined) {
                        this.pc++;
                    }
                    else if (this.world.getContents(dest.row, dest.col).getSpecies() === this.species) {
                        this.pc = address;
                    }
                    else
                        this.pc++;
                    break;

                case "ifenemy":
                    if (this.world.getContents(dest.row, dest.col) === undefined) {
                        this.pc++;
                    }
                    else if(this.world.getContents(dest.row, dest.col).getSpecies() !== this.species) {
                        this.pc = address;
                    }
                    else
                        this.pc++;
                    break;

                case "ifrandom":
                    let choice = Math.random();
                    if (choice < 0.5) {
                        this.pc = address;
                    }
                    else
                        this.pc++;
                    break;

                case "go":
                    this.pc = address;
                    break;

            }
        }
    }
}
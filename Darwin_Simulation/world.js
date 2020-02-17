/**
 * An instance of World represents the simulation world.  
 */
class World {

    /**
     * Constructs a World object.
     * @param {Number} w the width of this World (number of columns) 
     * @param {Number} h the height of this World (number of rows)
     */
    constructor( w, h ) {
        this.rows = h;
        this.columns = w;

        // The array containing the Species objects
        this.species = [];

        // The array containing all of the Creatures in this simulation
        this.creatures = [];

        this.loadSpecies();
        this.populate();
    }

    /**
     * Load the programs for each species and create a Species object for each,
     * and add to this.species.
     */
    loadSpecies() {
        let speciesElements = document.activeElement.getElementsByClassName('species-data');
        for(let spec of speciesElements) {
            this.species.push(new Species(spec.text));
        }
        
        // for(let i = 0; i<speciesElements.length; i++) {
        //     this.species.push(new Species(speciesElements[i].text));
        // }
    }

    /**
     * Create a random set of creatures with random positions and orientations.
     */
    populate() {
        for(let i = 0; i<100; i++) {
            let row = Math.floor(Math.random() * this.rows);
            let col = Math.floor(Math.random() * this.columns);
            if(this.getContents(row, col) === undefined){
                let loc = new Point(row, col);
                let dir = Geometry.randomDirection();
                let creat = new Creature(this.species[Math.floor(Math.random() * this.species.length)], loc, dir, this);
                //let creat = new Creature(this.species[0], loc, dir, this);
                this.addCreature(creat);
            }
        }
    }

    /**
     * Run one simulation step.  This is called from the main GUI.  It must iterate through
     * all creatures and execute takeOneTurn() for each.  For full credit, you must use the
     * forEach method:  this.creatures.forEach(..).
     */
    step() {
        this.creatures.forEach(function(entry){entry.takeOneTurn();});
    }

    /**
     * Searches the creature list to find the creature that exists at (row, col).  If
     * no such creature exists, it returns undefined.  For full credit, you must use the
     * find method: this.creatures.find(...).
     * 
     * @param {Number} row the row number 
     * @param {Number} col the column number
     * @returns {Creature} the Creature at (row, col) or undefined if no creature exists
     *     at that location.
     */
    getContents( row, col ) {
        return this.creatures.find(function(tempCreature){
            let loc = tempCreature.getLocation();
            if(loc.row == row && loc.col == col){
                return tempCreature;
            }
        });
    }

    getRows() { return this.rows; }
    getColumns() { return this.columns; }

    /**
     * Add a creature to this world.
     * @param {Creature} creature a Creature object.
     */
    addCreature( creature ) {
        this.creatures.push(creature);
    }

    /**
     * Returns whether or not point is in the valid range for this World.
     * 
     * @param {Point} point a point.
     * @return {Boolean} true if point is a valid location in this World.
     */
    inRange( point ) {
        if (point.row < this.rows && point.col < this.columns)
            if(point.row >= 0 && point.col >= 0){
                return true;
            }
        return false;
    }
}

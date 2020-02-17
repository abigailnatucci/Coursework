
/**
 * This class represents a species of creatures.  It primarily contains
 * the progrm code for the species.
 */
class Species {

    /**
     * Constructs a Species object from the given program code.
     * 
     * It should set the following properties:
     *    this.name -- the name of this species
     *    this.color -- the color of this species
     *    this.code  -- an array, containing the code for this species.  Each element of 
     *         this array should contain an object with the following two properties: 
     *         "opcode" and "address".  The "opcode" property is the name of the instruction,
     *         and "address" is the jump address (only needed for instructions that have a
     *         jump location).  For example: one possible entry in the array:
     *                { opcode: "ifenemy", address: 4 }
     * 
     * @param {string} code a string containing the program code for this Species. 
     */
    constructor( code ) {
        this.code = [];
        let result = code.split("\n");
        result.shift();
        let line = result[0].split(" ");
        this.name = line[0];
        this.color = line[1];
        let i = 1;
        let codeSection = [];
        //get only the opcode and address
        while(result[i] != ""){
            codeSection.push(result[i]);
            i++;
        }
        for(let i = 0; i<codeSection.length; i++){
            let newSection = codeSection[i].split(" ");
            this.code.push({
                opcode: newSection[0], address: newSection[1]
            });
        }
    }

    /**
     * Returns the code for instruction step.
     * 
     * @param {Number} step the instruction number.
     * @returns {Object} an object containing the instruction for example:  { opcode: "ifwall", address: 4 } 
     */
    programStep( step ) {
        return this.code[step];
    }
}
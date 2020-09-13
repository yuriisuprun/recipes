export class Recipe{

    recipeName:string;
    description:string;
    addedDate:Date;

    constructor(recipeName:string, description:string, addedDate:Date){
      this.recipeName=recipeName;
      this.description=description;
      this.addedDate=addedDate;
    }
}

export interface Transaction{
    transactionId:number;
    transactionType:string;
    userId:number;
    itemId:number;
    bytesValue:number;
    user: {
        currentBytes: number;
        firstName: string;
        role: Array<any>; 
        totalBytes: number;
        userId: number;
        userName: string;
        userPassword: string;
      };
}
import { FileHandle } from "./filehandle.model";

export interface Product {
    productId:number;
    productName: string;
    productDescription: string;
    productCategory: string;
    manufacturer: string;
    expiryDate: Date;
    quantityAvailable: number;
    termsAndConditions: string;
    featuredStatus: string;
    availabilityStatus: string;
    additionalMetadata: string;
    pointsInBytes: number;
    productImage:FileHandle[];
    imageView?:any;

    [key: string]: string | number | Date | FileHandle[] | Blob;
  }
  
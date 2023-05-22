import {Food} from "./food";

export interface CommandLine {
  commandLineId: string,
  food: Food,
  commandId: string,
  unitPrice: number,
  quantity: number,
  totalCommandLinePrice: number
}

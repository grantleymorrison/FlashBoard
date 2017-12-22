import { Rating } from "./rating";
import { Comment } from "./comment";

export class Question {
    id: number;
    question: string;
    options: string[];
    answer: string;
    points : number;
    rating : Rating;
    comment : Comment[];
}
import { Rating } from "./rating";
import { Comment } from "./comment";

export class Question {
    questionId: number;
    question: string;
    quizId: number;
    options: string[];
    answer: string;
    points : number;
    rating : Rating;
    comment : Comment[];
}
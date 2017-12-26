import { Comment } from './comment';
import { Question } from './question';

export class Quiz {
    quizId: number;
    quizTitle: string; // Quiz Name
    topic: string;
    description: string;
    username:string;
    createdDate: Date;
    maxScore: number;
    totalAttempts: number;
    questions : Question[];
    comments: Comment[];
    
}
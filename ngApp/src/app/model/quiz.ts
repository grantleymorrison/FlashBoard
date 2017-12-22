import { Comment } from './comment';
import { Question } from './question';

export class Quiz {
    id: number;
    name: string; // Quiz Name
    topic: string;
    description: string;
    creatorId: number;
    totalAttempts: number;
    questions : Question[];
    comments: Comment[];
    
}
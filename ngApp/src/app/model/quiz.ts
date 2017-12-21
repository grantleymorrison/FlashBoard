import { Comment } from './comment';

export class Quiz {
    id: number;
    name: string; // Quiz Name
    topic: string;
    description: string;
    creatorId: number;
    totalAttempts: number;
    comments: Comment[];
}
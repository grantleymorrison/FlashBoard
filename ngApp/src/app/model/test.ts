import { Comment } from './comment';

export class Test {
    id: number;
    name: string; // Test Name
    subject: string;
    description: string;
    creatorId: number;
    totalAttempts: number;
    comments: Comment[];
}
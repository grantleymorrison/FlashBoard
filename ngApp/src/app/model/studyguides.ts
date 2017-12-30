import { Rating } from "./rating";
import { Comment} from './comment';

export class StudyGuide {
    studyGuideId:number;
    title: string;
    body: string[];
    author: string;
    comment: Comment;
    rating: Rating;
    createdDate: Date;
}
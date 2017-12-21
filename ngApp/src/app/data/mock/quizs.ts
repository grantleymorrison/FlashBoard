import { Quiz } from '../../model/quiz';
import { Comment } from '../../model/comment';

export const MOCK_QUIZS: Quiz[] = [
    {
        id: 5,
        name: 'Java Scopes',
        topic: 'Java',
        description: 'How much do you know about scopes in Java?',
        creatorId: 1011,
        totalAttempts: 5,
        comments: [
            {
                id: 1001,
                commenterId: 1015,
                commenter: '2Spooki4Me',
                message: 'This test is bad'
            },
            {
                id: 1002,
                commenterId: 1011,
                commenter: 'writer001',
                message: 'get outta here dude'
            }
        ]
    },
    {
        id: 6,
        name: 'Lambdas',
        topic: 'Java',
        description: 'Lambdas are cool',
        creatorId: 1011,
        totalAttempts: 2,
        comments: [
            {
                id: 1001,
                commenterId: 1015,
                commenter: '2Spooki4Me',
                message: 'This test is also bad'
            },
            {
                id: 1002,
                commenterId: 1011,
                commenter: 'writer001',
                message: 'stop commenting on my test dude'
            }
        ]
    },

]
import { Quiz } from '../../model/quiz';
import { Comment } from '../../model/comment';

export const MOCK_QUIZS: Quiz[] = [
    {
        quizId: 5,
        quizTitle: 'Java Scopes',
        topic: 'Java',
        description: 'How much do you know about scopes in Java?',
        username: 'quizMaster',
        createdDate: new Date('Feb 13 2018'),
        maxScore:10,
        totalAttempts: 5,
        questions: [
            {
                questionId: 1,
                question: "What are four pillars of Object Oriented Programming?",
                quizId: 5,
                options:
                    [
                        "Contraction, Staticism, Capsulation, Specification",
                        "Abstraction, Encapsulation, Inheritence, Polymorphism",
                        "Normification, Invocation, Isolation, Gamification",
                        "Objectification, Orientation, Orange, Oraclism"
                    ],
                answer: "Abstraction, Encapsulation, Inheritence, Polymorphism",
                points: 5,
                rating:
                    {
                        ratingId: 10,
                        hard: 3,
                        easy: 3,
                        like: 5,
                        dislike: 1,
                    },
                comment:
                    [
                        {
                            commentId: 1111,
                            username: 'goodUser',
                            createdDate: new Date('12/25/2017'),
                            content: 'Good question'
                        }
                    ]
            },
            {
                questionId: 1,
                question: "Which of the following is NOT one of important features of Java 8 release?",
                quizId: 5,
                options: [
                    "Functional interfaces and Lambda Expressions",
                    "Interface changes with default and static methods",
                    "Java Stream API for collection classes",
                    "Inferred primitive datatype definition"
                ],
                answer: "Inferred primitive datatype definition",
                points: 5,
                rating: {
                    ratingId: 55,
                    hard: 10,
                    easy: 4,
                    like: 5,
                    dislike: 1,
                },
                comment: [
                    {
                        commentId: 1001,
                        username: 'someUser',
                        createdDate: new Date('12/25/2017'),
                        content: 'idk man'
                    }]
            }
        ],
        comments: [
            {
                commentId: 1001,
               createdDate: new Date('12/26/2017'),
                username: '2Spooki4Me',
                content: 'This test is bad'
            },
            {
                commentId: 1002,
                createdDate: new Date('12/26/2017'),
                username: 'writer001',
                content: 'get outta here dude'
            }
        ]
    }

]
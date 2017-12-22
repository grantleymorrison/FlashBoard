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
        questions: [
            {
                id: 1,
                question: "What are four pillars of Oject Oriented Programming?",
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
                        good: 5,
                        bad: 0,
                        hard: 3,
                        easy: 3,
                        like: 5,
                        dislike: 1,
                    },
                comment:
                    [
                        {
                            id: 1111,
                            userId: 111,
                            username: 'goodUser',
                            message: 'Good question'
                        }
                    ]
            },
            {
                id: 1,
                question: "Which of the following is NOT one of important features of Java 8 release?",
                options: [
                    "Functional interfaces and Lambda Expressions",
                    "Interface changes with default and static methods",
                    "Java Stream API for collection classes",
                    "Inferred primitive datatype definition"
                ],
                answer: "Inferred primitive datatype definition",
                points: 5,
                rating: {
                    good: 5,
                    bad: 0,
                    hard: 10,
                    easy: 4,
                    like: 5,
                    dislike: 1,
                },
                comment: [
                    {
                        id: 1001,
                        userId: 123,
                        username: 'someUser',
                        message: 'idk man'
                    }]
            }
        ],
        comments: [
            {
                id: 1001,
                userId: 1015,
                username: '2Spooki4Me',
                message: 'This test is bad'
            },
            {
                id: 1002,
                userId: 1011,
                username: 'writer001',
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
        questions: [],
        comments: [
            {
                id: 1001,
                userId: 1015,
                username: '2Spooki4Me',
                message: 'This test is also bad'
            },
            {
                id: 1002,
                userId: 1011,
                username: 'writer001',
                message: 'stop commenting on my test dude'
            }
        ]
    },

]
import { Component, OnInit } from "@angular/core";
import { Quiz } from "../../model/quiz";
import { QuizService } from "../../services/quiz/quiz.service";
import { of } from 'rxjs/observable/of';
import { Location } from '@angular/common';
import { ActivatedRoute } from "@angular/router";

@Component({
    selector: 'app-quiz',
    templateUrl: 'quiz.component.html',
    styleUrls: [
        'quiz.component.css'
    ]
})
export class QuizComponent implements OnInit {

    public quiz: Quiz;
    public userAnswers: string[];
    public takenStatus: boolean = false;
    selectedEntries: { [key: string]: any };
    public currentUser: String;

    //rating vars
    public easied: boolean = false;
    public harded: boolean = false;
    public liked: boolean = false;
    public disliked: boolean = false;
    //quiz score
    public correct: number;
    public incorrect: number;

    constructor(
        private route: ActivatedRoute,
        private quizService: QuizService,
        private location: Location
    ) { }

    //On init get Quizes from database
    ngOnInit() {
        this.getQuiz();
        this.correct = 0;
        this.incorrect = 0;
        console.log(of(this.quiz));
    }

    // Retrieve Quiz from database
    getQuiz(): void {
        let id = +this.route.snapshot.paramMap.get('id');
        this.quizService.getQuiz(id)
            .subscribe(quiz => this.quiz = quiz);

    }

    // User must be signed in to add comment
    submitComment(): void {
        if (!localStorage.getItem("currentUser")) {
            console.log("sign in yo")
        } else {

            // SEND COMMENTS HERE!!!!!

        }
    }

    // Check quiz answers
    submitQuiz(): void {
        if (!localStorage.getItem("currentUser")) {
            alert("Sign in if you want to check your answer.")
        }
        // check answer 
        else {
            let count = 0;
            for (let question of this.quiz.questions) {
                if (this.selectedEntries == undefined || this.selectedEntries[count] == undefined) {
                    alert("Not all answers are answered")
                    break;
                }

                if (question.answer == this.selectedEntries[count]) {
                    this.correct++;
                }
                else {
                    this.incorrect++;
                }
                count++;
            }
            this.takenStatus = true;
        }

    }
    // Goes back a page
    goBack(): void {
        this.location.back();
    }
    upEasy(qNum: number) {
        if (this.currentUser) {
            if (this.easied == false) {
                this.easied = true;
                this.quiz.questions[qNum].rating.easy++;
            }
            else {
                this.easied = false;
                if (this.quiz.questions[qNum].rating.easy >0)
                    this.quiz.questions[qNum].rating.easy--;
            }
        }
    }
    upHard(qNum: number) {
        if (this.currentUser) {
            if (this.harded == false) {
                this.harded = true;

                this.quiz.questions[qNum].rating.hard++;
            }
            else {
                this.harded = false;
                if (this.quiz.questions[qNum].rating.hard >0)
                this.quiz.questions[qNum].rating.hard--;
            }
        }
    }
    upLike(qNum: number) {
        if (this.currentUser) {
            if (this.liked == false) {
                this.liked = true;
                this.quiz.questions[qNum].rating.like++;
            }
            else {
                this.liked = false;
                if (this.quiz.questions[qNum].rating.like >0)
                this.quiz.questions[qNum].rating.like--;
            }
        }
    }
    upDislike(qNum: number) {
        if (this.currentUser) {
            if (this.disliked == false) {
                this.disliked = true;
                this.quiz.questions[qNum].rating.dislike++;
            }
            else {
                this.disliked = false;
                if (this.quiz.questions[qNum].rating.dislike >0)
                this.quiz.questions[qNum].rating.dislike--;
            }
        }
    }
    onSelection(entry, questionNum) {
        let obj = {};
        obj[questionNum] = entry;
        this.selectedEntries = Object.assign({}, this.selectedEntries, obj);
        console.log(this.selectedEntries)
    }

    getUser() {
        let currentUser = JSON.parse(localStorage.getItem("currentUser"))
        this.currentUser = this.parseJwt(currentUser.token.toString()).sub;
    }
    parseJwt(token) {
        let base64Url = token.split('.')[1];
        let base64 = base64Url.replace('-', '+').replace('_', '/');
        return JSON.parse(window.atob(base64));
    }

}
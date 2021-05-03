import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Statistics } from 'src/app/Class/Statistics/statistics';

@Injectable({
  providedIn: 'root'
})
export class StatisticsService {

  constructor(private http: HttpClient) { }

  getStatistics(){
    return this.http.get<Statistics>("/api/statistics/");
  }

}

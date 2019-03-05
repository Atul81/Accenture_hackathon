import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpInterceptor, HttpRequest, HttpHandler, HttpParams, HttpErrorResponse } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';


const apiURLLogin = 'http://localhost:8080/';

const apiURL = 'http://localhost:8080/accenture/'

@Injectable()
export class AppService {

  public headersExport = new HttpHeaders();

  authenticated = false;
  authenticationError = false;

  constructor(private http: HttpClient) {
  }

  authenticate(credentials, callback) {

    const headers = new HttpHeaders(credentials ? {
      authorization: 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    } : {});

    this.headersExport = headers;
    this.http.get(apiURLLogin + 'user', { headers: headers }).subscribe(response => {
      if (response['name']) {
        this.authenticated = true;
      } else {
        this.authenticated = false;
      }
      return callback && callback();
    },
    (error) => {
      this.authenticationError = true;
      this.handleError(error);
      alert(JSON.stringify(error));
      console.log("Fucked up");
    });

  }

  getAllCustomers() {
    return this.http.get(apiURL + 'listAllCustomer', { headers: this.headersExport });
  }

  findCustomerDetails(paramValue) {
    // let custId = new HttpParams().set("paramName", paramValue);
    return this.http.post(apiURL + 'findCustomer' + '/' + paramValue, null, { headers: this.headersExport });
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  };

}

@Injectable()
export class XhrInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const xhr = req.clone({
      headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
    });
    return next.handle(xhr);
  }
}

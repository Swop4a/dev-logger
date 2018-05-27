import { AbstractControl } from '@angular/forms';
import { of } from 'rxjs';

export class PasswordValidation {
  static MatchPassword(AC: AbstractControl) {
    const password = AC.root.get('password').value; // to get value in input tag
    const confirmPassword = AC.value; // to get value in input tag

    if (password !== confirmPassword) {
      return of({ matchPassword: true });
    } else {
      return of(null);
    }
  }
}

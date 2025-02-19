# Recitation 5 - Finite State Machines

## Learning Objective:

1. Develop experience with Java loops.
2. Design a Finite State Machine.
3. Implement a Finite State Machine.



## Email Addresses

The formal definition for email address formats are in RFC [5322](https://datatracker.ietf.org/doc/html/rfc5322) (sections 3.2.3 and 3.4.1) and RFC 5321.  The format of an email address is local-part@domain, where the local-part may be up to 64 UTF-8 characters long and the domain may have a maximum of 255 UTF-8 characters. The format of an email address is,

```
local-part@domain
```

the `local-part` may be quoted or unquoted.  This recitation will be concerned with the unquoted form of email addresses.

### Local-part

The unquoted `local-part` of an email may have any of the following [ASCII](https://en.wikipedia.org/wiki/ASCII) characters:

- uppercase and lowercase Latin letters `A` to `Z` and `a` to `z`
- digits `0` to `9`
- printable characters `!#$%&'*+-/=?^_`{|}~`
- dot `.`, provided that it is not the first or last character and provided also that it does not appear consecutively (e.g., `John..Doe@example.com` is not allowed).

### Domain

The domain name part must follow strict rules, which must match that for names allowed for hostnames.  The entire hostname, including the delimiting dots, has a maximum of 253 characters.  The domain name should be made up of list of dot-separated labels, each label being limited to a length of 63 characters and consisting of:

- Uppercase and lowercase Latin letters `A` to `Z` and `a` to `z`
- digits `0` to `9`
- Hyphen or minus`-`, provided that it is not the first or last character.

Implicit in this is that domain names cannot start or end with a dot (`.`).

### Example of Valid Email Address

- `jsmith@localhost`
- `jane@example.com`
- `jane.smith@example.com`
- `jane.smith@international.example.com`
- `jane/smith@example.com`
- `jane*smith-@example.com`

## Designing the Finite State Machine

The Finite State Machine (FSM) will be designed during the recitation.  Your task will be to implement the FSM in the accompanying `EmailValidator` class, specifically in the `isEmailValid` method.

## Task: Implementing The Finite State Machine

Your task is to implement the FSM that is designed during recitation in the `isEmailValid` method.


## Submitting Your Work

After completing the above tasks, submit your work by clicking the CodeGrade link in Blackboard.
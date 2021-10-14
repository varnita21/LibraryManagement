# LibraryManagement

Requirements
Create a command-line application for the library management system with the following requirements.

Details about the Library:
The library will have one or more copies of multiple books
The library will have multiple racks and each rack can contain at most one copy of any book.
Each book will have the following properties:
Book ID
Title
Authors
Publishers
Details about Book Copies
There could be multiple copies of the same book.
Each book copy will have a unique ID.
Each book copy will be placed on a rack.
Each book copy can be borrowed by a user with a specific due date.
Every rack will have a unique rack number (numbered serially from 1 to n where n is the total number of racks).
Details about User:
User details: User ID, Name
A user can borrow a maximum of 5 books.
The functions that the library management system can do:
Create a library.
Add a book to the library. The book should be added to the first available rack.
Remove a book copy from the library.
Allow a user to borrow a book copy given the book id, user id, and due date. The first available copy based on the rack number should be provided.
Allow a user to borrow a book copy given the book copy id, user id, and due date.
Allow a user to return a book copy given the book copy id. The book should be added to the first available rack.
Allow a user to print the book copy ids of all the books borrowed by them.
Allow a user to search for books using few book properties (Book ID, Title, Author, Publisher). Searching should return details about all the book copies that match the search query.


Examples
Sample Input
create_library 10
add_book 1 book1 author1,author2 publisher1 book_copy1,book_copy2,book_copy3
add_book 2 book2 author2,author3 publisher2,publisher3 book_copy4,book_copy5,book_copy6,book_copy7,book_copy8,book_copy9,book_copy10
add_book 3 book3 author2 publisher2 book_copy11,book_copy12,book_copy13
search book_id 1
search book_id 3
search author_id author2
search author_id author3
remove_book_copy book_copy6
remove_book_copy book_copy13
add_book 3 book3 author2 publisher2 book_copy13
search book_id 2
print_borrowed user1
borrow_book 1 user1 2020-12-31
borrow_book 1 user1 2020-12-31
borrow_book 1 user1 2020-12-31
borrow_book 1 user1 2020-12-31
search book_id 1
search author_id author1
borrow_book 4 user1 2020-12-31
borrow_book 2 user1 2020-12-31
borrow_book 2 user1 2020-12-31
borrow_book 2 user1 2020-12-31
print_borrowed user1
return_book_copy book_copy1
return_book_copy book_copy2
borrow_book_copy book_copy1
borrow_book_copy book_copy1
borrow_book_copy book_copy2
borrow_book_copy book_copy10
print_borrowed user1
exit
Expected Output
Created library with 10 racks
Added Book to racks: 1,2,3
Added Book to racks: 4,5,6,7,8,9,10
Rack not available
Book Copy: book_copy1 1 book1 author1,author2 publisher1 1
Book Copy: book_copy2 1 book1 author1,author2 publisher1 2
Book Copy: book_copy3 1 book1 author1,author2 publisher1 3
Book Copy: book_copy1 1 book1 author1,author2 publisher1 1
Book Copy: book_copy2 1 book1 author1,author2 publisher1 2
Book Copy: book_copy3 1 book1 author1,author2 publisher1 3
Book Copy: book_copy4 2 book2 author2,author3 publisher2,publisher3 4
Book Copy: book_copy5 2 book2 author2,author3 publisher2,publisher3 5
Book Copy: book_copy6 2 book2 author2,author3 publisher2,publisher3 6
Book Copy: book_copy7 2 book2 author2,author3 publisher2,publisher3 7
Book Copy: book_copy8 2 book2 author2,author3 publisher2,publisher3 8
Book Copy: book_copy9 2 book2 author2,author3 publisher2,publisher3 9
Book Copy: book_copy10 2 book2 author2,author3 publisher2,publisher3 10
Book Copy: book_copy4 2 book2 author2,author3 publisher2,publisher3 4
Book Copy: book_copy5 2 book2 author2,author3 publisher2,publisher3 5
Book Copy: book_copy6 2 book2 author2,author3 publisher2,publisher3 6
Book Copy: book_copy7 2 book2 author2,author3 publisher2,publisher3 7
Book Copy: book_copy8 2 book2 author2,author3 publisher2,publisher3 8
Book Copy: book_copy9 2 book2 author2,author3 publisher2,publisher3 9
Book Copy: book_copy10 2 book2 author2,author3 publisher2,publisher3 10
Removed book copy: book_copy6 from rack: 6
Invalid Book Copy ID
Added Book to racks: 6
Book Copy: book_copy4 2 book2 author2,author3 publisher2,publisher3 4
Book Copy: book_copy5 2 book2 author2,author3 publisher2,publisher3 5
Book Copy: book_copy7 2 book2 author2,author3 publisher2,publisher3 7
Book Copy: book_copy8 2 book2 author2,author3 publisher2,publisher3 8
Book Copy: book_copy9 2 book2 author2,author3 publisher2,publisher3 9
Book Copy: book_copy10 2 book2 author2,author3 publisher2,publisher3 10
Borrowed Book from rack: 1
Borrowed Book from rack: 2
Borrowed Book from rack: 3
Not available
Book Copy: book_copy1 1 book1 author1,author2 publisher1 -1 user1 2020-12-31
Book Copy: book_copy2 1 book1 author1,author2 publisher1 -1 user1 2020-12-31
Book Copy: book_copy3 1 book1 author1,author2 publisher1 -1 user1 2020-12-31
Book Copy: book_copy1 1 book1 author1,author2 publisher1 -1 user1 2020-12-31
Book Copy: book_copy2 1 book1 author1,author2 publisher1 -1 user1 2020-12-31
Book Copy: book_copy3 1 book1 author1,author2 publisher1 -1 user1 2020-12-31
Invalid Book ID
Borrowed Book from rack: 4
Borrowed Book from rack: 5
Overlimit
Book Copy: book_copy1 2020-12-31
Book Copy: book_copy2 2020-12-31
Book Copy: book_copy3 2020-12-31
Book Copy: book_copy4 2020-12-31
Book Copy: book_copy5 2020-12-31
Returned book copy book_copy1 and added to rack: 1
Returned book copy book_copy2 and added to rack: 2
Borrowed Book from rack: 1
Invalid Book Copy ID
Borrowed Book from rack: 2
Overlimit
Book Copy: book_copy1 2020-12-31
Book Copy: book_copy2 2020-12-31
Book Copy: book_copy3 2020-12-31
Book Copy: book_copy4 2020-12-31
Book Copy: book_copy5 2020-12-31

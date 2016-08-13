<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookstore Cassandra Rest</title>
<script src="static/js/angular.js"></script> 
<script src="static/js/createBookCtrl.js"></script>

<link rel="stylesheet" href="static/css/bootstrap.css"></link>
<script src="static/js/jquery.min.js"></script>
  <script src="static/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="static/css/style.css"> 

</head>
<body>


<div class="container" ng-app="createBook" ng-controller="createBookCtrl">
<div class="boxIt">
<button title="Click to Add Book" type="button" class=" addBtn btn btn-info" data-toggle="collapse" data-target="#book">+</button>
	<table  class="table table-hover" show-filter="true">
		<thead>
		<tr class="success">
			<td>Name</td><td>Author</td><td>Code</td>
			<td>Price</td><td>Isbn</td><td>Publisher</td>
			<td>Published Date</td><td></td><td></td>
		</tr>
		<tr class="info collapse" id="book">
			<td><input type="text" ng-model="book.name"></td>
			<td><input type="text" ng-model="book.author"></td>
			<td><input type="text" ng-model="book.code"></td>
			<td><input type="number" ng-model="book.price"></td>
			<td><input type="text" ng-model="book.isbn"></td>
			<td><input type="text" ng-model="book.publisher"></td>
			<td><input type="date" ng-model="book.publishedOn"></td>
			<td><input type="button" value="Submit" data-toggle="collapse" data-target="#book" class="btn btn-info" ng-click="createBook()"></td>
			<td></td>
		</tr>
		</thead>
		<tbody ng-init="getBooks()">
		<tr class="info collapse" id="editBook">
			<td><input type="text" ng-model="edit.name"></td>
			<td><input type="text" ng-model="edit.author"></td>
			<td><input type="text" ng-model="edit.code"></td>
			<td><input type="number" ng-model="edit.price"></td>
			<td><input type="text" ng-model="edit.isbn"></td>
			<td><input type="text" ng-model="edit.publisher"></td>
			<td><input type="date" ng-model="edit.publishedOn"></td>
			<td><input type="button" value="Submit" class="btn btn-info" data-toggle="collapse" data-target="#editBook" ng-click="editBook(edit)"></td>
			<td></td>
		</tr> 

			<tr ng-repeat="book in books">
				<td title="'Name'" filter="{ name: 'text'}" sortable="'name'" id="{{book.id}}"> <span ng-bind="book.name"></span></td>
				<td title="'Author'" filter="{ author: 'text'}" sortable="'author'" id="{{book.id}}"> <span ng-bind="book.author"></span></td>
				<td title="'Code'" filter="{ code: 'text'}" id="{{book.id}}"> <span ng-bind="book.code"></span></td>
				<td title="'Price'" filter="{ price: 'number'}" sortable="'price'" id="{{book.id}}"> <span ng-bind="book.price"></span></td>
				<td title="'Isbn'" filter="{ isbn: 'text'}"> <span ng-bind="book.isbn" id="{{book.id}}"></span></td>
				<td title="'Publisher'" filter="{ publisher: 'text'}" id="{{book.id}}"> <span ng-bind="book.publisher"></span></td>
				<td title="'Published Date'" id="{{book.id}}"> <span>{{book.publishedOn | date}}</span></td>
				<td><button name="edit" ng-click="openEditBook(book)" type="button" class="btn btn-info" data-toggle="collapse" data-target="#editBook">Edit</button></td>
				<td><button name="delete" class="btn btn-danger" ng-click="deleteBook(book)">Delete</button></td>
			</tr>
			  
		</tbody>
	</table>
</div>
</div>

</body>
</html>
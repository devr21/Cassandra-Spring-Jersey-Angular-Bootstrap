angular.module('createBook', []).controller('createBookCtrl', function($scope,$http) {
    
	console.log("Working!!");
	
	
	
	$scope.createBook = function(){
		var book = new Object();
		book.id = null;
		book.name = $scope.book.name;
		book.code = $scope.book.code;
		book.price = $scope.book.price;
		book.author = $scope.book.author;
		book.isbn = $scope.book.isbn;
		book.publisher = $scope.book.publisher;
		book.publishedOn = $scope.book.publishedOn;
		
		var req = {
				method:'POST',
				url:'http://localhost:8080/jersey/api/bookservice/book',
				headers:{
					ContentType:'application/json'
				},
				data:book
		}
		console.log("sending request");
		$http(req).then(function success(response){
			if(success.status >= 400){
				$scope.book = null;
				$scope.response = "Something wrong happend!!!";
			}
			else{
			$scope.book = null;
				$scope.getBooks();
				
			}
		})
		
	}
	
	$scope.getBooks = function(){
		console.log("getting books");
		$http.get("http://localhost:8080/jersey/api/bookservice/getBooks")
		.success(function(data,status,header,config){
			
			console.log(data);
			 $scope.books = data;
		})
		.error(function(){
			console.log("Error in fetching books !!");
		})
	}
	
	$scope.deleteBook = function(book){
		console.log(book.id);
			$http.delete("/jersey/api/bookservice/book/"+book.id).
			success(function(){
				var index = $scope.books.indexOf(book);
				$scope.books.splice(index,1);
			})
			.error(function(data,status){
				console.log("couldn't delete the book status : "+status);
			})
		}

		$scope.openEditBook = function(book){
			book.price = parseInt(book.price);
		book.publishedOn = new Date(book.publishedOn);

		$scope.edit = book;
		}
	
	$scope.editBook = function(book){
		
		

		var req = {
				method:'PUT',
				url:'/jersey/api/bookservice/book',
				headers:{
					ContentType:'application/json'
				},
				data:book
		}
		
		$http(req).then(function success(){
			var index = $scope.books.indexOf(book);
			$scope.books[index] = book;
			$scope.edit = null;
		})
	}
	
});
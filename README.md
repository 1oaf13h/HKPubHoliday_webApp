# A. Compilation, Start and Test


    -   

    -   Due to the time limit, no test is done



# B. Diary

    1. Day 1

    	-   Implementation:
	
            -	Figured out what dependencies are needed for the web application
                    -	Thymeleaf:		display HTML page 
                    -	Spring web:		Spring MVC
                    -	Spring data JPA:	Interact with the database without using SQL
                    -	lombok:		reduce effort on write repetitive code 
                                    e.g., getter/setter
                    -	etc.


            -	class "PublicHolidayItemService"
			    -	provides basic methods to interact with the database:
				    -	e.g.,	retrieve holidays from the database, get the .JSON file of the public holidays from the website, etc.


            -	interface "PublicHolidayRepo":
				    -	define the method signatures to search, delete, and insert holiday items


        -   Database:
		    -	Decided what database to be used:  
                -   H2 Database	(lightweight database, can be both presistent / in-memory database)

    2. Day 2


        -   Implementation:
	
            -	Created controllers "HomeController" and "PublicHolidayController"
            
                -	"HomeController"
                    -	Return the index .html page 
                    
                -	PublicHolidayController
                    -	Handle the buttons "Get Data" and "Search", inlcuding retrieve .json file of the HK public holiday and update the database
                        (In-progress)

        -   Web page templates:
        
            -	Created a index .html page with a rough skeleton for the application
                (still missing buttons "Get", "Search", and fields for date pickers)
                
                
            -	Tried to experience the pagination and find example for online resources


        -   Database:
            -	Setup the database with a simple structure that stores a list of holidays with certain required attributes:
                -	Table "publicHoliday_item:
                    -	uid:		String  (primary key)
                    -	dtstart:	LocalDate
                    -	dtend:		LocalDate
                    -	summary:	string

    3. Day 3

        -   Implementation:
	
            -	Modified the interface "PublicHolidayRepo":
            
                -	Find all the hoildays within the "dtstart" and "dtend" using JPA Native Query
            
            
            -	Modified the class "PublicHolidayController"
            
                -	Retrieve the .json file of the public holidays from the webpage, and then insert all of them into the database
                
                -	Search all holidays the between the specified dates "dtstart" and "dtend"
			
	
        -   Web page templates:
            
            -   Return the specified dates "StartDate" and "EndDate" as the parameters back to the method "serachRangeHoliday"

            -   Added 2 input fields for the datepickers (rather than using the datepicker implemented with Bootstrap for the simplification) to the dates "StartDate"  and "EndDate

            -	Temporarily define style in the index.html page, where can't find 
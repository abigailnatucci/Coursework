--Author: Abigail Natucci

-- convert a binary integer to a decimal integer
binaryToDecimal :: Int -> Int
binaryToDecimal 0 = 0
binaryToDecimal x = 2 * binaryToDecimal (x `div` 10) + (x `mod` 10)

-- addtwo binary numbers together
addBinary :: [Int] -> Int
addBinary [] = 0
addBinary [x] = x

-- retreive the last element in a list
last' :: [a] -> a
last' [] = error "please do not call with empty list"
last' [x] = x
last' (x:xs) = last' xs

-- retreive the first element in a list
init' :: [a] -> [a]
init' [] = error "please do not call with empty list"
init' [x] = []
init' (x:xs) = x: init' xs

-- return true if palindrome
palindrome :: [Char] -> Bool
palindrome [] = True
palindrome [x] = True
palindrome x = x == reverse x

-- filter match out of the list
filterOut :: (a -> Bool) -> [a] -> [a]
filterOut f [] = []
filterOut f (x:xs) 
    | f x = filterOut f xs
    | otherwise = x: filterOut f xs

-- count the number of times element appears in list
nTimes :: Int -> (Int -> Int) -> [Int]
nTimes n f = [ f(n) | n <- [0..n-1]]

--count occurences in list
count :: (a -> Bool) -> [a] -> Int
count f [] = 0
count f (x:xs) 
    | f x = 1 + count f xs
    | otherwise = count f xs

-- insert item into list    
insert :: (Ord a) => a -> [a] -> [a]
insert x [] = [x]
insert x (y:ys)
    | x <= y = x:(y:ys)
    | otherwise = y : insert x ys

-- insertion sort algorithm implementation     
insertionSort :: (Ord a) => [a] -> [a]
insertionSort [] = []
insertionSort (x:xs) = insert x (insertionSort xs)

-- combine two lists into one
combine :: (a -> a -> a) -> [a] -> [a] -> [a]
combine f [] [] = []

-- returns the minimum element in a list
minimum' :: (Ord a) => [a] -> a
minimum' [] = error "The list is empty"
minimum' [x] = x
minimum' (x:xs) = min x (minimum' xs)
    where min x y
            | x > y = y 
            | x < y = x
            | x == y = x

-- return true if all items in the list are true            
allTrue :: [Bool] -> Bool
allTrue [] = True
allTrue (x:xs)
    | x == False = False
    | otherwise = allTrue xs

-- return true if any item in the list is true    
anyTrue :: [Bool] -> Bool
anyTrue [] = False
anyTrue (x:xs)
    | x == True = True
    | otherwise = anyTrue xs

-- creates a list of length given by the first argument and the items having value of the second argument   
replicate' :: Int -> a -> [a]
replicate' x y = [y | _ <- [1..x]]

-- takes in a list of strings(as a character list) and returns a list of their lengths
lengths :: [[Char]] -> [Int]
lengths = map length

--returns a list of all divors for a given list
divisors :: [Int] -> [[Int]]
let divisors n = [x | x <- [1..(n-1)], n `rem` x == 0]











        






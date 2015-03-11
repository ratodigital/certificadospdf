def list = datastore.execute {
	select all
	from "log"
}

map = [:]
list.each { l -> 
	if (map[l.email]) { 	
		map.put(l.email,map[l.email]+1)	
	} else {
		map[l.email] = 1
	}
}

map.each { k,v ->
	println "$k,$v<br>"
}

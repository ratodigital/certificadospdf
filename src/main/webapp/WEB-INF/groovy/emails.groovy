def list = datastore.execute {
	select all
	from "log"
}

map = [:]
list.each { l -> 
	def emailNome = l.email+","+l.name
	if (map[emailNome]) { 	
		map.put(l.email,map[emailNome]+1)	
	} else {
		map[emailNome] = 1
	}
}

map.each { k,v ->
	println "$k,$v<br>"
}

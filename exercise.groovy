package org.example

import org.codehaus.groovy.util.StringUtil


class Exercise {


    static void main(String[] args){
        ArrayList list = new ArrayList()
        HashMap map = new HashMap()
        map.put("id" , "1")
        map.put("text", "hi and birthday")
        ArrayList requirement = new ArrayList()
        HashMap requirementTypeValue = new HashMap()
        requirementTypeValue.put("requirementType", "birthday")
        requirement.add(requirementTypeValue)
        HashMap requirementTypeValue2 = new HashMap()
        requirementTypeValue2.put("requirementType", "health")
        requirement.add(requirementTypeValue2)
        map.put("requirement", requirement)
        ArrayList matchIds = new ArrayList()
        matchIds.add(1)
        matchIds.add(2)
        map.put("matchId", matchIds)
        list.add(map)



        //second test case
        ArrayList list2 = new ArrayList()
        HashMap map2 = new HashMap()
        map2.put("id" , "1")
        map2.put("text", "hi and happy mother day")
        ArrayList requirement2 = new ArrayList()
        HashMap requirementTypeValues = new HashMap()
        requirementTypeValues.put("requirementType", "name")
        requirement2.add(requirementTypeValues)
        HashMap requirementTypeValue3 = new HashMap()
        requirementTypeValue3.put("requirementType", "gifts")
        requirement.add(requirementTypeValue3)
        map2.put("requirement", requirement)
        list2.add(map2)

        //third test case
        ArrayList list3 = new ArrayList()
        HashMap map3 = new HashMap()
        map3.put("id" , "1")
        map3.put("text", "May the fourth be with you")
        ArrayList matchId3 = new ArrayList()
        matchId3.add(1)
        matchId3.add(2)
        map3.put("matchId", matchId3)
        list3.add(map3)


        //fourth test case
        ArrayList list4 = new ArrayList()
        HashMap map4 = new HashMap()
        map4.put("id" , "1")
        map4.put("text", "Welcome to Summer")
        list4.add(map4)

        //fourth fifth case
        ArrayList list5 = new ArrayList()
        HashMap map5 = new HashMap()
        map5.put("id" , "1")
        map5.put("text", " ")
        list5.add(map5)

        println("List1"+  list)
        println("List2" +  list2)
        println("List3" +  list3)
        println("List4" +  list4)
        println("List5" +  list5)
        Set givenRequirment = new HashSet()
        givenRequirment.add("birthday")
        givenRequirment.add("newYear")
     System.out.println(getMessage(list5, givenRequirment, 2))


    }

    //Object of list
    // 1: hi and birthday
    // if the requirement
    static List<HashMap<Long, String>> getMessage(List<HashMap<String, String>> lists, Set givenRequirements, matchIds){
        //if value RequirementType is in givenRequirements and matchIds is in  1: text
        //if  value RequirementType is in givenRequirements and matchIds does not exist the key doesnt exist
       //givenRequirement = {"birthday", "anniverary"}
        //matchIds = 1
        Iterator<?> iterateList = lists.iterator()
        List<HashMap<String, String>> result = new ArrayList()
        print(iterateList)
        if(!lists.isEmpty()){
            if(iterateList.hasNext()){
               for(t in iterateList){ //for(t : iterateList
                    String message = t["text"]
                    List<String> requirments = t["requirement"]
                    List<String> matchIdList = t["matchId"]
                    if(!message.isEmpty()){
                        if(t.hasProperty("requirement")){
                            for(Map<String, String> r in requirments){
                                if(givenRequirements.contains(r.get("requirementType"))  && !t.hasProperty("matchId")){ //first condition // if any value is in the list
                                    String id = t["id"]
                                    HashMap<String, String> newList = new HashMap()
                                    newList.put(id, message)
                                    result.add(newList)

                                }else if(givenRequirements.contains(r.get("requirementType"))  && t.hasProperty("matchId")) {
                                    if(matchIdList.contains(matchIds)){
                                        String id = t["id"]
                                        HashMap<String, String> newList = new HashMap()
                                        newList.put(id, message)
                                        result.add(newList)
                                    }
                                }
                            }
                        }else if(!t.hasProperty("requirement") && t.hasProperty("matchId")){
                            if(matchIdList.contains(matchIds)){
                                String id = t["id"]
                                HashMap<String, String> newList = new HashMap()
                                newList.put(id, message)
                                result.add(newList)
                            }
                        }else if(!t.hasProperty("requirement") && !t.hasProperty("matchId") ){

                                String id = t["id"]
                                HashMap<String, String> newList = new HashMap()
                                newList.put(id, message)
                                result.add(newList)

                        }
                    }else{
                        String id = t["id"]
                        HashMap<String, String> newList = new HashMap()
                        newList.put(id, message)
                        result.add(newList)

                    }

                }
            }
        }

   return result

    }


}

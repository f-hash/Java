package org.example

import org.codehaus.groovy.util.StringUtil

import java.util.stream.Collectors


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
        map2.put("id" , "2")
        map2.put("text", "hi and happy mother day")
        ArrayList requirement6 = new ArrayList()
        HashMap requirementTypeValues3 = new HashMap()
        requirementTypeValues3.put("requirementType", "name")
        requirement6.add(requirementTypeValues3)
        HashMap requirementTypeValue6 = new HashMap()
        requirementTypeValue6.put("requirementType", "gifts")
        requirement6.add(requirementTypeValue6)
        map2.put("requirement", requirement6)
        list.add(map2)


        //third test case
        ArrayList list3 = new ArrayList()
        HashMap map3 = new HashMap()
        map3.put("id" , "3")
        map3.put("text", "May the fourth be with you")
        ArrayList matchId3 = new ArrayList()
        matchId3.add(1)
        matchId3.add(2)
        map3.put("matchId", matchId3)
        list.add(map3)


        //fourth test case
        ArrayList list4 = new ArrayList()
        HashMap map4 = new HashMap()
        map4.put("id" , "4")
        map4.put("text", "Welcome to Summer")
        list.add(map4)

        //fourth fifth case
        ArrayList list5 = new ArrayList()
        HashMap map5 = new HashMap()
        map5.put("id" , "5")
        map5.put("text", " ")
        list.add(map5)
        
        Set givenRequirment = new HashSet()
        givenRequirment.add("birthday")
        givenRequirment.add("health")
        givenRequirment.add("name")



     System.out.println(getMessage(list, givenRequirment, 2))


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

                        if(t.containsKey("requirement")){
                            for(Map<String, String> r in requirments){
                                if(givenRequirements.contains(r.get("requirementType"))  && !t.containsKey("matchId")){ //first condition // if any value is in the list
                                    String id = t["id"]
                                    HashMap<String, String> newList = new HashMap()
                                    newList.put(id, message)
                                    result.add(newList)

                                }else if(givenRequirements.contains(r.get("requirementType"))  && t.containsKey("matchId")) {

                                    if(matchIdList.contains(matchIds)){
                                        String id = t["id"]
                                        HashMap<String, String> newList = new HashMap()
                                        newList.put(id, message)
                                        result.add(newList)
                                    }
                                }
                            }
                        }else if(!t.containsKey("requirement") && t.containsKey("matchId")){
                            if(matchIdList.contains(matchIds)){
                                String id = t["id"]
                                HashMap<String, String> newList = new HashMap()
                                newList.put(id, message)
                                result.add(newList)
                            }
                        }else if(!t.containsKey("requirement") && !t.containsKey("matchId") ){


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

   return result.stream().distinct().collect(Collectors.toList())

    }


}

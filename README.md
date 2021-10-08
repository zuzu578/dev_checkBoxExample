# dev_checkBoxExample
여러개의 분류체계 체크박스를 선택하고 , 데이터를 select해본다.
예를들어 이런것이 있다고 치자.

![tqtqtq](https://user-images.githubusercontent.com/69393030/136499502-632345a1-25fb-416f-b191-9920c0383888.JPG)
첫번째줄 check box 는 sort1 
두번째줄은 sort2 인데 
아마 동적으로 checkbox 값을 서버에서 불러올때마다 sort는 5까지 늘어난다는 전제하에..

검색을 누르게 되면 
파라미터를 서버에 전달한다.

# parameter!
![qwdqwd](https://user-images.githubusercontent.com/69393030/136499648-91760759-ed90-4d7a-8ec3-bafebf89d6ab.JPG)
이때 체크박스 체크된 값을 서버에서 받을땐 List 로 받아줘야한다.
@RequestParam required 를 true 로 설정하면 , 체크되지않은 값이 parameter로 전달될때 400 에러를 리턴하므로 , false 로 해둔다.
그리고 해당 체크박스에 체크된값을 list 로 마이바티스에서 전달하여 foreach 로 돌려준다 그렇게되면
where 1 = 1 and sort1 in ( ) or sort2 in () or ... 로 된다 
이 기능은 hash 태그 기능과 유사하다. 
![12312312312312](https://user-images.githubusercontent.com/69393030/136499780-a75df310-c4c7-4c0b-949c-af3b8e66d37a.JPG)

# mybatis 에서 foreach 문쓰기 

 WHERE 1 = 1
		 	AND T2.COL_ID = #{colId}
            <if test='sort1 != null and sort1 !=""'>
            AND sort1 in
             <foreach item="sort1" index="index" collection="sort1" open="(" separator="," close=")">
            #{sort1}
            </foreach>
            </if>
            <if test='sort2 != null and sort2 !=""'>
            OR sort2 in
             <foreach item="sort2" index="index" collection="sort2" open="(" separator="," close=")">
			#{sort2}
			</foreach>
			</if>
			<if test='sort3 != null and sort3 !=""'>
			OR sort3 in
			 <foreach item="sort3" index="index" collection="sort3" open="(" separator="," close=")">
			#{sort3}
			</foreach>
			</if>
			<if test='sort4 != null and sort4 !=""'>
			OR sort4 IN
			 <foreach item="sort4" index="index" collection="sort4" open="(" separator="," close=")">
			#{sort4}
			</foreach>
			</if>
			<if test='sort5 != null and sort5 !=""'>
			OR sort5 IN
			 <foreach item="sort5" index="index" collection="sort5" open="(" separator="," close=")">
			#{sort5}
			</foreach>
			</if>
      
      대충 이렇게 된다. 

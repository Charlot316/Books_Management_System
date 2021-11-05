<template>
    <div class="main">
        <el-button type="text" @click="goback">返回</el-button>
        <el-table :data="returnedList">
        <el-table-column type="index"></el-table-column>
        <el-table-column label="图书ID" prop="book_id" width="50px"></el-table-column>
        <el-table-column width="100px"></el-table-column>
        <el-table-column
          label="书籍名称"
          width="200px"
          prop="bName"
        ></el-table-column>
        <el-table-column width="100px"></el-table-column>
        <el-table-column label="借阅时间" prop="lDate"></el-table-column>
        <el-table-column width="100px"></el-table-column>
        <el-table-column label="归还时间" prop="rDate"></el-table-column>
        <el-table-column width="100px"></el-table-column>
        <el-table-column label="操作">
          <template #default="scope">
            <el-button
              type="primary"
              icon="el-icon-info"
              size="mini"
              @click="viewdetail(scope.$index)"
              >图书详情</el-button
            >
          </template>
        </el-table-column>
       </el-table>
      <!--分页区域-->
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="bookInfo.pageNum"
        :page-size="bookInfo.pageSize"
        :page-sizes="[1, 5, 10, 20]"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        class="el-pagination"
        background
      >
      </el-pagination>

    <!--图书详情的弹出框-->
      <el-dialog
        title="图书详情"
        v-model="viewVisible"
        width="50%"
        class="el-dialog"
      >
        <div class="test">
          <el-form ref="form" :model="form" label-width="30%" class="el-form">
            <el-form-item label="图书索引号">
              <el-input v-model="form.book_index" readonly></el-input>
            </el-form-item>
            <el-form-item label="图书名称">
              <el-input v-model="form.bName" readonly></el-input>
            </el-form-item>
            <el-form-item label="图书作者">
              <el-input v-model="form.bAuthor" readonly></el-input>
            </el-form-item>
            <el-form-item label="图书类型">
              <el-input v-model="form.bType" readonly></el-input>
            </el-form-item>
            <el-form-item label="图书出版社">
              <el-input v-model="form.bPublisher" readonly></el-input>
            </el-form-item>
            <el-form-item label="图书馆藏书量">
              <el-input v-model="form.bAllCount" readonly></el-input>
            </el-form-item>
            <el-form-item label="图书在馆数量">
              <el-input v-model="form.bInCount" readonly></el-input>
            </el-form-item>
            <el-form-item label="图书被借次数">
              <el-input v-model="form.bLendCount" readonly></el-input>
            </el-form-item>
            <el-form-item label="图书简介">
              <el-input
                v-model="form.bIntroduction"
                type="textarea"
                :rows="7"
                readonly
              ></el-input>
            </el-form-item>
          </el-form>
        </div>
      </el-dialog>

    </div>    
</template>
<script>
export default{
    data(){
        return{
            bookInfo:{
                user_id: "",
                pageNum: 1,
                pageSize: 5
            },
            queryInfo: {
                bName: "",
                pageNum: 1,
                pageSize: 5
            },
            returnedList:[],
            total:"" ,
            viewVisible: false,
            form: {}
        }
    },
    computed:{
        userid() {
            let userid = this.$store.state.user_id;
            return userid
        },
        Role() {
            let role = this.$store.state.role;
            return role;
        },
    },
    created(){
        if(this.$store.state.role===1){
            this.showReturnedBook();
        }
        else {
            this.$message.error("工作人员不允许查看这些界面，请使用私人账号访问");
            this.$router.push('/user');
        }
    },
    methods: {
        goback() {
          this.$router.push({ path: "/User" });
        },
        async showReturnedBook() {
            this.bookInfo.user_id = this.userid
            if((this.bookInfo.pageSize*(this.bookInfo.pageNum-1))>=this.total){
                this.bookInfo.pageNum = 1;
            }
            const {data: res} = await this.$http.post('showReturnedBook',this.bookInfo)
            this.returnedList = []
            if(res.status==200){
                this.total = res.total
                for(let i=0;i<res.list.length;i++){
                    let model={};
                    model["user_id"] = res.list[i].user_id;
                    model["book_id"] = res.list[i].book_id;
                    model["lDate"] = res.list[i].lDate;
                    model["rDate"] = res.list[i].rDate;
                    model["bName"] = res.bookList[i];
                    this.returnedList[i] = model
                }
            }
            else{
                this.total = 0;
            }
        },
        handleSizeChange(newSize){
            this.bookInfo.pageSize = newSize;
            this.showReturnedBook();
        },
        handleCurrentChange(newPage){
            this.bookInfo.pageNum = newPage;
            this.showReturnedBook();
        },
        async viewdetail(index) {
            this.viewVisible = true;
            this.queryInfo.bName = this.returnedList[index].bName
            const {data: res} = await this.$http.post('searchBook',this.queryInfo)
            res.bookList[0].book_index = this.returnedList[index].book_id
            this.form = res.bookList[0]
        },
    }
}
</script>
<style scoped>
.main{
    width: 100%;
}
.el-pagination{
  margin-top: 15px;
  margin-left: 25%;
}
</style>
